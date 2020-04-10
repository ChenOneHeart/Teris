/*    */ package ui.window;
/*    */ 
/*    */ import config.FrameConfig;
/*    */ import config.GameConfig;
/*    */ import javax.swing.JFrame;
/*    */ import util.FrameUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JFrameGame
/*    */   extends JFrame
/*    */ {
/*    */   public JFrameGame(JPanelGame panelGame) {
/* 14 */     FrameConfig fCfg = GameConfig.getFrameConfig();
/*    */     
/* 16 */     setTitle(fCfg.getTitle());
/*    */     
/* 18 */     setDefaultCloseOperation(3);
/*    */     
/* 20 */     setSize(fCfg.getWidth(), fCfg.getHeight());
/*    */     
/* 22 */     setResizable(false);
/*    */     
/* 24 */     FrameUtil.setFrameCenter(this);
/*    */     
/* 26 */     setContentPane(panelGame);
/*    */     
/* 28 */     setVisible(true);
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\window\JFrameGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */