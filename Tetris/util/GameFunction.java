/*    */ package util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameFunction
/*    */ {
/*    */   public static long getSleepTimeByLevel(int level) {
/* 11 */     long sleep = (-40 * level + 740);
/* 12 */     sleep = (sleep < 100L) ? 100L : sleep;
/* 13 */     return sleep;
/*    */   }
/*    */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\util\GameFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */