/*     */ package dto;
/*     */ 
/*     */ import config.GameConfig;
/*     */ import entity.GameAct;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import util.GameFunction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameDto
/*     */ {
/*  20 */   public static final int GAMEZONE_W = GameConfig.getSystemConfig().getMaxX() + 1;
/*     */ 
/*     */ 
/*     */   
/*  24 */   public static final int GAMEZONE_H = GameConfig.getSystemConfig().getMaxY() + 1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Player> dbRecode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Player> diskRecode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean[][] gameMap;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private GameAct gameAct;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int next;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int nowlevel;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int nowPoint;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int nowRemoveLine;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean start;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean showShadow;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean pause;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cheat;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long sleepTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public GameDto() { dtoInit(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dtoInit() {
/* 102 */     this.gameMap = new boolean[GAMEZONE_W][GAMEZONE_H];
/* 103 */     this.nowlevel = 1;
/* 104 */     this.nowPoint = 0;
/* 105 */     this.nowRemoveLine = 0;
/* 106 */     this.pause = false;
/* 107 */     this.cheat = false;
/* 108 */     this.sleepTime = GameFunction.getSleepTimeByLevel(this.nowlevel);
/*     */   }
/*     */ 
/*     */   
/* 112 */   public List<Player> getDbRecode() { return this.dbRecode; }
/*     */ 
/*     */ 
/*     */   
/* 116 */   public void setDbRecode(List<Player> dbRecode) { this.dbRecode = setFillRecode(dbRecode); }
/*     */ 
/*     */ 
/*     */   
/* 120 */   public List<Player> getDiskRecode() { return this.diskRecode; }
/*     */ 
/*     */ 
/*     */   
/* 124 */   public void setDiskRecode(List<Player> diskRecode) { this.diskRecode = setFillRecode(diskRecode); }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Player> setFillRecode(List<Player> players) {
/* 129 */     if (players == null) {
/* 130 */       players = new ArrayList<>();
/*     */     }
/*     */     
/* 133 */     while (players.size() < 5) {
/* 134 */       players.add(new Player("No Data", 0));
/*     */     }
/* 136 */     Collections.sort(players);
/* 137 */     return players;
/*     */   }
/*     */ 
/*     */   
/* 141 */   public boolean[][] getGameMap() { return this.gameMap; }
/*     */ 
/*     */ 
/*     */   
/* 145 */   public void setGameMap(boolean[][] gameMap) { this.gameMap = gameMap; }
/*     */ 
/*     */ 
/*     */   
/* 149 */   public GameAct getGameAct() { return this.gameAct; }
/*     */ 
/*     */ 
/*     */   
/* 153 */   public void setGameAct(GameAct gameAct) { this.gameAct = gameAct; }
/*     */ 
/*     */ 
/*     */   
/* 157 */   public int getNext() { return this.next; }
/*     */ 
/*     */ 
/*     */   
/* 161 */   public void setNext(int next) { this.next = next; }
/*     */ 
/*     */ 
/*     */   
/* 165 */   public int getNowlevel() { return this.nowlevel; }
/*     */ 
/*     */   
/*     */   public void setNowlevel(int nowlevel) {
/* 169 */     this.nowlevel = nowlevel;
/*     */     
/* 171 */     this.sleepTime = GameFunction.getSleepTimeByLevel(this.nowlevel);
/*     */   }
/*     */ 
/*     */   
/* 175 */   public int getNowPoint() { return this.nowPoint; }
/*     */ 
/*     */ 
/*     */   
/* 179 */   public void setNowPoint(int nowPoint) { this.nowPoint = nowPoint; }
/*     */ 
/*     */ 
/*     */   
/* 183 */   public int getNowRemoveLine() { return this.nowRemoveLine; }
/*     */ 
/*     */ 
/*     */   
/* 187 */   public void setNowRemoveLine(int nowRemoveLine) { this.nowRemoveLine = nowRemoveLine; }
/*     */ 
/*     */ 
/*     */   
/* 191 */   public boolean isStart() { return this.start; }
/*     */ 
/*     */ 
/*     */   
/* 195 */   public void setStart(boolean start) { this.start = start; }
/*     */ 
/*     */ 
/*     */   
/* 199 */   public boolean isShowShadow() { return this.showShadow; }
/*     */ 
/*     */ 
/*     */   
/* 203 */   public void changeShowShadow() { this.showShadow = !this.showShadow; }
/*     */ 
/*     */ 
/*     */   
/* 207 */   public boolean isPause() { return this.pause; }
/*     */ 
/*     */ 
/*     */   
/* 211 */   public void changePause() { this.pause = !this.pause; }
/*     */ 
/*     */ 
/*     */   
/* 215 */   public boolean isCheat() { return this.cheat; }
/*     */ 
/*     */ 
/*     */   
/* 219 */   public void setCheat(boolean cheat) { this.cheat = cheat; }
/*     */ 
/*     */ 
/*     */   
/* 223 */   public long getSleepTime() { return this.sleepTime; }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\dto\GameDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */