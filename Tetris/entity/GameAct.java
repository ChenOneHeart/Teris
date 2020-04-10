/*    */ package entity;
/*    */ 
/*    */ import config.GameConfig;
/*    */ import java.awt.Point;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameAct
/*    */ {
/* 13 */   private Point[] actPoints = null;
/*    */ 
/*    */ 
/*    */   
/*    */   private int typeCode;
/*    */ 
/*    */   
/* 20 */   private static final int MIN_X = GameConfig.getSystemConfig().getMinX();
/* 21 */   private static final int MAX_X = GameConfig.getSystemConfig().getMaxX();
/* 22 */   private static final int MIN_Y = GameConfig.getSystemConfig().getMinY();
/* 23 */   private static final int MAX_Y = GameConfig.getSystemConfig().getMaxY();
/* 24 */   private static final List<Point[]> TYPE_CONFIG = GameConfig.getSystemConfig().getTypeConfig();
/* 25 */   private static final List<Boolean> TYPE_ROUND = GameConfig.getSystemConfig().getTypeRound();
/*    */ 
/*    */   
/* 28 */   public GameAct(int typeCode) { init(typeCode); }
/*    */ 
/*    */   
/*    */   public void init(int typeCode) {
/* 32 */     this.typeCode = typeCode;
/* 33 */     Point[] points = TYPE_CONFIG.get(typeCode);
/* 34 */     this.actPoints = new Point[points.length];
/* 35 */     for (int i = 0; i < points.length; i++) {
/* 36 */       this.actPoints[i] = new Point((points[i]).x, (points[i]).y);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/* 41 */   public Point[] getActPoints() { return this.actPoints; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean move(int moveX, int moveY, boolean[][] gameMap) {
/* 51 */     for (int i = 0; i < this.actPoints.length; i++) {
/* 52 */       int newX = (this.actPoints[i]).x + moveX;
/* 53 */       int newY = (this.actPoints[i]).y + moveY;
/* 54 */       if (isOverZone(newX, newY, gameMap)) {
/* 55 */         return false;
/*    */       }
/*    */     } 
/* 58 */     for (int i = 0; i < this.actPoints.length; i++) {
/* 59 */       (this.actPoints[i]).x += moveX;
/* 60 */       (this.actPoints[i]).y += moveY;
/*    */     } 
/* 62 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void round(boolean[][] gameMap) {
/* 71 */     if (!((Boolean)TYPE_ROUND.get(this.typeCode)).booleanValue()) {
/*    */       return;
/*    */     }
/* 74 */     for (int i = 1; i < this.actPoints.length; i++) {
/* 75 */       int newX = (this.actPoints[0]).y + (this.actPoints[0]).x - (this.actPoints[i]).y;
/* 76 */       int newY = (this.actPoints[0]).y - (this.actPoints[0]).x + (this.actPoints[i]).x;
/* 77 */       if (isOverZone(newX, newY, gameMap)) {
/*    */         return;
/*    */       }
/*    */     } 
/* 81 */     for (int i = 1; i < this.actPoints.length; i++) {
/* 82 */       int newX = (this.actPoints[0]).y + (this.actPoints[0]).x - (this.actPoints[i]).y;
/* 83 */       int newY = (this.actPoints[0]).y - (this.actPoints[0]).x + (this.actPoints[i]).x;
/* 84 */       (this.actPoints[i]).x = newX;
/* 85 */       (this.actPoints[i]).y = newY;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 92 */   private boolean isOverZone(int x, int y, boolean[][] gameMap) { return !(x >= MIN_X && x <= MAX_X && y >= MIN_Y && y <= MAX_Y && !gameMap[x][y]); }
/*    */ 
/*    */ 
/*    */   
/* 96 */   public int getTypeCode() { return this.typeCode; }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\entity\GameAct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */