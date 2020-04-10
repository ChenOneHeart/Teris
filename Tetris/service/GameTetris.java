/*     */ package service;
/*     */ 
/*     */ import config.GameConfig;
/*     */ import dto.GameDto;
/*     */ import entity.GameAct;
/*     */ import java.awt.Point;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameTetris
/*     */   implements GameService
/*     */ {
/*     */   private GameDto dto;
/*  21 */   private Random random = new Random();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  26 */   private static final int MAX_TYPE = GameConfig.getSystemConfig().getTypeConfig().size() - 1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  31 */   private static final int LEVEL_UP = GameConfig.getSystemConfig().getLevelUp();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   private static final Map<Integer, Integer> PLUS_POINT = GameConfig.getSystemConfig().getPlusPoint();
/*     */ 
/*     */   
/*  39 */   public GameTetris(GameDto dto) { this.dto = dto; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyUp() {
/*  46 */     if (this.dto.isPause()) {
/*  47 */       return true;
/*     */     }
/*  49 */     synchronized (this.dto) {
/*  50 */       this.dto.getGameAct().round(this.dto.getGameMap());
/*     */     } 
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyDown() {
/*  59 */     if (this.dto.isPause()) {
/*  60 */       return true;
/*     */     }
/*  62 */     synchronized (this.dto) {
/*     */       
/*  64 */       if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap())) {
/*  65 */         return false;
/*     */       }
/*     */       
/*  68 */       boolean[][] map = this.dto.getGameMap();
/*     */       
/*  70 */       Point[] act = this.dto.getGameAct().getActPoints();
/*     */       
/*  72 */       for (int i = 0; i < act.length; i++) {
/*  73 */         map[(act[i]).x][(act[i]).y] = true;
/*     */       }
/*     */       
/*  76 */       int plusExp = plusExp();
/*     */       
/*  78 */       if (plusExp > 0)
/*     */       {
/*  80 */         plusPoint(plusExp);
/*     */       }
/*     */       
/*  83 */       this.dto.getGameAct().init(this.dto.getNext());
/*     */       
/*  85 */       this.dto.setNext(this.random.nextInt(MAX_TYPE));
/*     */       
/*  87 */       if (isLose())
/*     */       {
/*  89 */         this.dto.setStart(false);
/*     */       }
/*     */     } 
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isLose() {
/* 100 */     Point[] actPoints = this.dto.getGameAct().getActPoints();
/*     */     
/* 102 */     boolean[][] map = this.dto.getGameMap();
/* 103 */     for (int i = 0; i < actPoints.length; i++) {
/* 104 */       if (map[(actPoints[i]).x][(actPoints[i]).y]) {
/* 105 */         return true;
/*     */       }
/*     */     } 
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void plusPoint(int plusExp) {
/* 116 */     int lv = this.dto.getNowlevel();
/*     */     
/* 118 */     int rmLine = this.dto.getNowRemoveLine();
/*     */     
/* 120 */     int point = this.dto.getNowPoint();
/*     */     
/* 122 */     if (rmLine % LEVEL_UP + plusExp >= LEVEL_UP)
/*     */     {
/* 124 */       this.dto.setNowlevel(++lv);
/*     */     }
/*     */     
/* 127 */     this.dto.setNowPoint(point + ((Integer)PLUS_POINT.get(Integer.valueOf(plusExp))).intValue());
/*     */     
/* 129 */     this.dto.setNowRemoveLine(rmLine + plusExp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyLeft() {
/* 136 */     if (this.dto.isPause()) {
/* 137 */       return true;
/*     */     }
/* 139 */     synchronized (this.dto) {
/* 140 */       this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
/*     */     } 
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyRight() {
/* 149 */     if (this.dto.isPause()) {
/* 150 */       return true;
/*     */     }
/* 152 */     synchronized (this.dto) {
/* 153 */       this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
/*     */     } 
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int plusExp() {
/* 163 */     boolean[][] map = this.dto.getGameMap();
/* 164 */     int exp = 0;
/*     */     
/* 166 */     for (int y = 0; y < GameDto.GAMEZONE_H; y++) {
/*     */       
/* 168 */       if (isCanRemoveLine(y, map)) {
/*     */         
/* 170 */         removeLine(y, map);
/*     */         
/* 172 */         exp++;
/*     */       } 
/*     */     } 
/* 175 */     return exp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeLine(int rowNumber, boolean[][] map) {
/* 182 */     for (int x = 0; x < GameDto.GAMEZONE_W; x++) {
/* 183 */       for (int y = rowNumber; y > 0; y--) {
/* 184 */         map[x][y] = map[x][y - 1];
/*     */       }
/* 186 */       map[x][0] = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCanRemoveLine(int y, boolean[][] map) {
/* 195 */     for (int x = 0; x < GameDto.GAMEZONE_W; x++) {
/* 196 */       if (!map[x][y])
/*     */       {
/* 198 */         return false;
/*     */       }
/*     */     } 
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyFunUp() {
/* 209 */     this.dto.setCheat(true);
/* 210 */     plusPoint(4);
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyFunDown() {
/* 219 */     if (this.dto.isPause())
/* 220 */       return true;  do {
/*     */     
/* 222 */     } while (!keyDown());
/* 223 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyFunLeft() {
/* 231 */     this.dto.changeShowShadow();
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyFunRight() {
/* 240 */     this.dto.changePause();
/* 241 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startGame() {
/* 247 */     this.dto.setNext(this.random.nextInt(MAX_TYPE));
/*     */     
/* 249 */     this.dto.setGameAct(new GameAct(this.random.nextInt(MAX_TYPE)));
/*     */     
/* 251 */     this.dto.setStart(true);
/*     */     
/* 253 */     this.dto.dtoInit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 258 */   public void mainAction() { keyDown(); }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\service\GameTetris.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */