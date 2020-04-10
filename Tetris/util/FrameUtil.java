/*    */ package util;
/*    */ 
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FrameUtil
/*    */ {
/*    */   public static void setFrameCenter(JFrame jf) {
/* 15 */     Toolkit toolkit = Toolkit.getDefaultToolkit();
/*    */     
/* 17 */     Dimension screen = toolkit.getScreenSize();
/* 18 */     int x = screen.width - jf.getWidth() >> 1;
/* 19 */     int y = (screen.height - jf.getHeight() >> 1) - 32;
/* 20 */     jf.setLocation(x, y);
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\util\FrameUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */