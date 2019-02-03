package application;
import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
/**
 * bdConnect est la classe représentant la connexion à la base de données MySQL
 * Cette classe contient:
 * <ul> 
 * <li> Une méthode connection qui permet de vérifier la connexion à la BD
 * <li> Une méthode getNumLigneNiveau(int) qui renvoit les numéros des lignes d'un niveau
 * <li> Une méthode getHiraganaNiveau(int) qui renvoit les images des hiraganas d'un niveau
 * <li> Une méthode getRomaji(int) qui renvoit les romaji des hiraganas d'un niveau
 * <li> Une méthode getHiraganaId(int) qui renvoit un hiragana à partir de son id dans la BD
 * <li> Une méthode getLigneNiveau(int) qui renvoit les 2 images des lignes d'un niveau
 * <li> Une méthode getAllJoueur qui renvoit tout les joueurs de la BD
 * <li> Une méthode getPassWord(String) qui renvoit le MDP d'un joueur
 * <li> Une méthode insertPlayer(String,String) qui permet d'inserer un joueur dans la BD
 * <li> Une méthode setHiraganaTrue(String) qui permet de noté si un hiragana est vu
 * <li> Une méthode resetHiraganaFalse() qui permet de remettre tout les hiraganas vus à non vu 
 * </ul>
 *
 * @author BARRET Gaëtan
 */
public class bdConnect {
	public static void main (String[]args){
		setScoreJoueur(1,"admin");
	}
	
	private Statement st;
	private Connection cn;
	
	private bdConnect(){
		String url = "";
		String login = "";
		String passwd = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection(url, login, passwd);
			this.st = this.cn.createStatement();
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			} 
	}
	
	public static bdConnect bd = null;
	
	public static bdConnect getInstance(){
		bd = new bdConnect();
		return bd;
	}
	
	public static Connection getCn(){
		return getInstance().cn;
	}
	
	
	public static Statement getSt(){
		return getInstance().st;
	}
	
	public static void closeConnect(){
		try {
			getInstance().cn.close();
			getInstance().st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Image convert(Blob b){
		Image img = null;
		try {
			InputStream in = b.getBinaryStream();
			img = SwingFXUtils.toFXImage(ImageIO.read(in), null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static String[] getNumLigneNiveau(int niv){
		String[] res = new String[2];
		int i = 0;
		ResultSet rs = null;
		try{
			String sql = "SELECT IDLIGNE FROM LIGNE WHERE IDNIV = " + niv +"";
			rs = getSt().executeQuery(sql);
				while (rs.next() )  {				
					res[i] = rs.getString("IDLIGNE");
					i++;
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();				 			
			}
		return res;
		
	}
	
	public static Image[] getHiraganaNiveau(int niv) {
		ResultSet rs = null;
		Image[] img = new Image[10];
		String[] lignes = getNumLigneNiveau(niv);
		int i = 0;
		try{
			String sql = "SELECT SYMBOLE FROM HIRAGANA WHERE IDLIGNE IN ("+lignes[0]+","+lignes[1]+")" ;
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					img[i] = convert(rs.getBlob("SYMBOLE"));
					i++;
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		return img;	
	}
	
	public static String[] getRomaji(int niv){
		ResultSet rs = null;
		String[] res = new String[10];
		String[] lignes = getNumLigneNiveau(niv);
		int i = 0;
		try{
			String sql = "SELECT ROMAJI FROM HIRAGANA WHERE IDLIGNE IN ("+lignes[0]+","+lignes[1]+")" ;
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					res[i] = rs.getString("ROMAJI");
					i++;
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		return res;	
	}
	
	public static Image getHiraganaId(int id) {
		ResultSet rs = null;
		Image res = null;
		try{
			String sql = "SELECT SYMBOLE,ROMAJI FROM HIRAGANA WHERE IDHIR =" + id +"";
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {
					res = convert(rs.getBlob("SYMBOLE"));
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		return res;
	}
	
	public static Image[] getLigneNiveau(int niv){
		ResultSet rs = null;
		Image[] img = new Image[2];
		String[] lignes = getNumLigneNiveau(niv);
		int i = 0;
		try{
			String sql = "SELECT LIGNETAB,IDLIGNE FROM LIGNE WHERE IDLIGNE IN ("+lignes[0]+","+lignes[1]+")" ;
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					img[i] = convert(rs.getBlob("LIGNETAB"));
					i++;
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		return img;		
	}
	
	public static String[] getAllJoueur(){
		ResultSet rs = null;
		ArrayList<String> array = new ArrayList<String>();
		try{
			String sql = "SELECT PSEUDO FROM JOUEUR" ;
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					array.add(rs.getString("PSEUDO"));
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		String[] res = array.toArray(new String[array.size()]);
		return res;	
	}
	
	public static String getPassWord(String name){
		ResultSet rs = null;
		String res = null;
		try{
			String sql = "SELECT MDP FROM JOUEUR WHERE PSEUDO = '" + name + "'" ;
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					res = rs.getString("MDP");					
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		return res;	
	}
	
	public static void insertPlayer(String pseudo, String mdp){
		try{
			String sql = "INSERT INTO JOUEUR (PSEUDO,MDP) VALUES ('"+pseudo +"','"+ mdp+"')";
			getSt().executeUpdate(sql);			
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
	}
	
	public static void setHiraganaTrue(String romaji, String joueur){
		try{
			String sql = "UPDATE CONNAITRE SET HIRAGANAVU = 1 WHERE IDJOUEUR =  ( SELECT IDJOUEUR FROM JOUEUR WHERE PSEUDO = '" + joueur + "') AND IDHIR = (SELECT IDHIR FROM HIRAGANA WHERE ROMAJI = '" + romaji + "')";
			getSt().executeUpdate(sql);
			
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
	}
	
	public static void resetHiraganaFalse(String joueur){
		try{
			String sql = "UPDATE CONNAITRE SET HIRAGANAVU = 0 WHERE IDJOUEUR =  ( SELECT IDJOUEUR FROM JOUEUR WHERE PSEUDO = '" + joueur + "')";
			getSt().executeUpdate(sql);
			
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
	}
	
	public static boolean getHiraganaBoolean(String romaji, String joueur){
		ResultSet rs = null;
		Boolean res = false;
		try{
			String sql = "SELECT HIRAGANAVU FROM CONNAITRE WHERE IDJOUEUR =  ( SELECT IDJOUEUR FROM JOUEUR WHERE PSEUDO = '" + joueur + "') AND IDHIR = (SELECT IDHIR FROM HIRAGANA WHERE ROMAJI = '" + romaji + "')";
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					res = rs.getBoolean("HIRAGANAVU");					
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		return res;
	}
	
	public static String nomVille(int niv){
			ResultSet rs = null;
			String res = null;
			try{
				String sql = "SELECT NOMVILLE FROM NIVEAU WHERE IDNIV = " + niv+ "";
				//exécution requête
				rs = getSt().executeQuery(sql);
				//parcours Resultset
					while (rs.next() )  {		
						res = rs.getString("NOMVILLE");					
					} 
				}
			catch (SQLException e) {
				e.printStackTrace();
				} 
			finally {
					closeConnect();
				}
			return res;	
	}
	
	public static void villeVu(String joueur, int niveau){
		try{
			String sql = "UPDATE AVANCER SET NIVEAUEFFECTUE = 1 WHERE IDJOUEUR =  ( SELECT IDJOUEUR FROM JOUEUR WHERE PSEUDO = '" + joueur + "') AND IDNIV = " + niveau +"";
			getSt().executeUpdate(sql);
			
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
	}
	
	public static int getScoreJoueur(String nom){
		ResultSet rs = null;
		int res = 0;
		try{
			String sql = "SELECT SCORETOTAL FROM JOUEUR WHERE PSEUDO = '" + nom + "'";
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					res = rs.getInt("SCORETOTAL");					
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		return res;	
	}
	
	public static void setScoreJoueur(int i,String joueur){
		try{
			String sql = "UPDATE JOUEUR SET SCORETOTAL = " + i + " WHERE PSEUDO = '" + joueur + "'";
			getSt().executeUpdate(sql);
			System.out.println("Je suis appelé");
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
	}
	
	/* Renvoi false si aucun pseudo similaire n'est trouvé */
	public static boolean exist(String pseudo){
		ResultSet rs = null;
		int r = 0;
		boolean res = true;
		try{
			String sql = "SELECT COUNT(*) FROM JOUEUR WHERE PSEUDO = '" + pseudo + "'";
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					r = rs.getInt("COUNT(*)");					
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		if(r == 0){
			res = false;
		}
		
		return res;
	}
	
	public static int niveauVu(String pseudo){
		ResultSet rs = null;
		int[] res = new int[5];
		int i = 0;
		try{
			String sql = "SELECT IDNIV FROM AVANCER WHERE IDJOUEUR =  ( SELECT IDJOUEUR FROM JOUEUR WHERE PSEUDO = '" + pseudo + "') AND NIVEAUEFFECTUE = 1 ORDER BY IDNIV DESC" ;
			//exécution requête
			rs = getSt().executeQuery(sql);
			//parcours Resultset
				while (rs.next() )  {		
					res[i] = rs.getInt("IDNIV");		
					i++;
				} 
			}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		finally {
				closeConnect();
			}
		int a = res[0];
		return a;
	}
	
}
