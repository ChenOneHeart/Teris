/*    */ package ui;
/*    */ 
/*    */ import config.GameConfig;
/*    */ import dto.Player;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class LayerData
/*    */   extends Layer
/*    */ {
/* 15 */   private static final int MAX_ROW = GameConfig.getDataConfig().getMaxRow();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 20 */   private static int STATR_Y = 0;
/*    */   
/* 22 */   private static final int RECT_H = IMG_RECT_H + 4;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   private static int SPA = 0;
/*    */   
/*    */   public LayerData(int x, int y, int w, int h) {
/* 30 */     super(x, y, w, h);
/*    */     
/* 32 */     SPA = (this.h - (IMG_RECT_H + 4) * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW;
/*    */     
/* 34 */     STATR_Y = PADDING + Img.DB.getHeight(null) + SPA;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void paint(Graphics paramGraphics);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void showData(Image imgTitle, List<Player> palyers, Graphics g) {
/* 49 */     g.drawImage(imgTitle, this.x + PADDING, this.y + PADDING, null);
/*    */     
/* 51 */     int nowPoint = this.dto.getNowPoint();
/*    */     
/* 53 */     for (int i = 0; i < MAX_ROW; i++) {
/*    */       
/* 55 */       Player pla = palyers.get(i);
/*    */       
/* 57 */       int recodePoint = pla.getPoint();
/*    */       
/* 59 */       double percent = nowPoint / recodePoint;
/*    */       
/* 61 */       percent = (percent > 1.0D) ? 1.0D : percent;
/*    */       
/* 63 */       String strPoint = (recodePoint == 0) ? null : Integer.toString(recodePoint);
/* 64 */       drawRect(STATR_Y + i * (RECT_H + SPA), 
/* 65 */           pla.getName(), strPoint, 
/* 66 */           percent, g);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */