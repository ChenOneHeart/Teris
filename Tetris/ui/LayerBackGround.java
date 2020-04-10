/*    */ package ui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class LayerBackGround
/*    */   extends Layer
/*    */ {
/*  8 */   public LayerBackGround(int x, int y, int w, int h) { super(x, y, w, h); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics g) {
/* 13 */     int bgIdx = this.dto.getNowlevel() % Img.BG_LIST.size();
/* 14 */     g.drawImage(Img.BG_LIST.get(bgIdx), 0, 0, 1168, 680, null);
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\LayerBackGround.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */