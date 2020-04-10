/*    */ package dao;
/*    */ 
/*    */ import dto.Player;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataBase
/*    */   implements Data
/*    */ {
/*    */   private final String dbUrl;
/*    */   private final String dbUser;
/*    */   private final String dbPwd;
/* 22 */   private static String LOAD_SQL = "SELECT user_name, point FROM user_point WHERE type_id = 1 ORDER BY point DESC LIMIT 0,5";
/*    */   
/* 24 */   private static String SAVE_SQL = "INSERT INTO user_point (user_name,point,type_id) VALUES (?,?,?)";
/*    */   
/*    */   public DataBase(HashMap<String, String> param) {
/* 27 */     this.dbUrl = param.get("dbUrl");
/* 28 */     this.dbUser = param.get("dbUser");
/* 29 */     this.dbPwd = param.get("dbPwd");
/*    */     try {
/* 31 */       Class.forName(param.get("driver"));
/* 32 */     } catch (ClassNotFoundException e) {
/* 33 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Player> loadData() {
/* 39 */     Connection conn = null;
/* 40 */     PreparedStatement stmt = null;
/* 41 */     ResultSet rs = null;
/* 42 */     List<Player> players = new ArrayList<>();
/*    */     try {
/* 44 */       conn = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
/* 45 */       stmt = conn.prepareStatement(LOAD_SQL);
/* 46 */       rs = stmt.executeQuery();
/* 47 */       while (rs.next()) {
/* 48 */         players.add(new Player(rs.getString(1), rs.getInt(2)));
/*    */       }
/* 50 */     } catch (Exception e) {
/* 51 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 54 */         if (conn != null) conn.close(); 
/* 55 */         if (stmt != null) stmt.close(); 
/* 56 */         if (rs != null) rs.close(); 
/* 57 */       } catch (SQLException e) {
/* 58 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/* 61 */     return players;
/*    */   }
/*    */ 
/*    */   
/*    */   public void saveData(Player players) {
/* 66 */     Connection conn = null;
/* 67 */     PreparedStatement stmt = null;
/*    */     try {
/* 69 */       conn = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
/* 70 */       stmt = conn.prepareStatement(SAVE_SQL);
/* 71 */       stmt.setObject(1, players.getName());
/* 72 */       stmt.setObject(2, Integer.valueOf(players.getPoint()));
/* 73 */       stmt.setObject(3, Integer.valueOf(1));
/* 74 */       stmt.execute();
/* 75 */     } catch (Exception e) {
/* 76 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 79 */         if (conn != null) conn.close(); 
/* 80 */         if (stmt != null) stmt.close(); 
/* 81 */       } catch (SQLException e) {
/* 82 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\dao\DataBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */