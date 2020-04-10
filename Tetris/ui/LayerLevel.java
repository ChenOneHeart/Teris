/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class LayerLevel
/*    */   extends Layer
/*    */ {
/*  8 */   private static final int IMG_LV_W = Img.LEVEL.getWidth(null);
/*    */ 
/*    */   
/* 11 */   public LayerLevel(int x, int y, int w, int h) { super(x, y, w, h); }
/*    */   
/*    */   public void paint(Graphics g) {
/* 14 */     createWindow(g);
/* 15 */     int centerX = this.w - IMG_LV_W >> 1;
/*    */     
/* 17 */     g.drawImage(Img.LEVEL, this.x + centerX, this.y + PADDING, null);
/*    */     
/* 19 */     drawNumberLeftPad(centerX, 54, this.dto.getNowlevel(), 2, g);
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */