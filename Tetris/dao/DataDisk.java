/*    */ package dao;
/*    */ 
/*    */ import dto.Player;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class DataDisk
/*    */   implements Data
/*    */ {
/*    */   private final String filepath;
/*    */   
/* 18 */   public DataDisk(HashMap<String, String> param) { this.filepath = param.get("path"); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Player> loadData() {
/* 24 */     ObjectInputStream ois = null;
/* 25 */     List<Player> players = null;
/*    */     try {
/* 27 */       ois = new ObjectInputStream(new FileInputStream(this.filepath));
/* 28 */       players = (List<Player>)ois.readObject();
/* 29 */     } catch (Exception e) {
/* 30 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 33 */         ois.close();
/* 34 */       } catch (Exception e) {
/* 35 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/* 38 */     return players;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void saveData(Player pla) {
/* 44 */     List<Player> players = loadData();
/*    */     
/* 46 */     players.add(pla);
/*    */     
/* 48 */     ObjectOutputStream oos = null;
/*    */     try {
/* 50 */       oos = new ObjectOutputStream(new FileOutputStream(this.filepath));
/* 51 */       oos.writeObject(players);
/* 52 */     } catch (Exception e) {
/* 53 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 56 */         oos.close();
/* 57 */       } catch (IOException e) {
/* 58 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\dao\DataDisk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */