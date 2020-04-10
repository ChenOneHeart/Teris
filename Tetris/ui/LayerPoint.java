/*    */ package ui;
/*    */ 
/*    */ import config.GameConfig;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LayerPoint
/*    */   extends Layer
/*    */ {
/*    */   private static final int POINT_BIT = 5;
/* 17 */   private static final int LEVEL_UP = GameConfig.getSystemConfig().getLevelUp();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int rmlineY;
/*    */ 
/*    */ 
/*    */   
/*    */   private final int pointY;
/*    */ 
/*    */ 
/*    */   
/*    */   private final int expY;
/*    */ 
/*    */ 
/*    */   
/*    */   private final int comX;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LayerPoint(int x, int y, int w, int h) {
/* 40 */     super(x, y, w, h);
/*    */     
/* 42 */     this.comX = this.w - IMG_NUMBER_W * 5 - PADDING;
/*    */     
/* 44 */     this.pointY = PADDING;
/*    */     
/* 46 */     this.rmlineY = this.pointY + Img.POINT.getHeight(null) + PADDING;
/*    */     
/* 48 */     this.expY = this.rmlineY + Img.RMLINE.getHeight(null) + PADDING;
/*    */   }
/*    */   
/*    */   public void paint(Graphics g) {
/* 52 */     createWindow(g);
/*    */     
/* 54 */     g.drawImage(Img.POINT, this.x + PADDING, this.y + this.pointY, null);
/*    */     
/* 56 */     drawNumberLeftPad(this.comX, this.pointY, this.dto.getNowPoint(), 5, g);
/*    */     
/* 58 */     g.drawImage(Img.RMLINE, this.x + PADDING, this.y + this.rmlineY, null);
/*    */     
/* 60 */     drawNumberLeftPad(this.comX, this.rmlineY, this.dto.getNowRemoveLine(), 5, g);
/*    */     
/* 62 */     int rmline = this.dto.getNowRemoveLine();
/*    */     
/* 64 */     drawRect(this.expY, "下一级", null, (rmline % LEVEL_UP) / LEVEL_UP, g);
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */