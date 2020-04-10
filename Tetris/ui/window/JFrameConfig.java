/*     */ package ui.window;
/*     */ 
/*     */ import control.GameControl;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import ui.Img;
/*     */ import util.FrameUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JFrameConfig
/*     */   extends JFrame
/*     */ {
/*  39 */   private JButton btnOK = new JButton("确定");
/*     */   
/*  41 */   private JButton btnCancel = new JButton("取消");
/*     */   
/*  43 */   private JButton btnUser = new JButton("应用");
/*     */   
/*  45 */   private TextCtrl[] keyText = new TextCtrl[8];
/*     */   
/*  47 */   private JLabel errorMsg = new JLabel();
/*     */   
/*  49 */   private JList<String> skinList = null;
/*     */   
/*  51 */   private JPanel skinView = null;
/*     */   
/*  53 */   private DefaultListModel<String> skinData = new DefaultListModel<>();
/*     */   
/*     */   private GameControl gameControl;
/*     */   
/*  57 */   private static final Image IMG_PSP = (new ImageIcon("data/psp.jpg")).getImage();
/*     */   
/*  59 */   private Image[] skinViewList = null;
/*     */   
/*  61 */   private static final String[] METHOD_NAMES = new String[] {
/*  62 */       "keyRight", "keyUp", "keyLeft", "keyDown", 
/*  63 */       "keyFunLeft", "keyFunUp", "keyFunRight", "keyFunDown"
/*     */     };
/*     */   
/*     */   private static final String PATH = "data/control.dat";
/*     */ 
/*     */   
/*     */   public JFrameConfig(GameControl gameControl) {
/*  70 */     this.gameControl = gameControl;
/*     */     
/*  72 */     setLayout(new BorderLayout());
/*  73 */     setTitle("设置");
/*     */     
/*  75 */     initKeyText();
/*     */     
/*  77 */     add(createMainPanel(), "Center");
/*     */     
/*  79 */     add(createButtonPanel(), "South");
/*     */     
/*  81 */     setResizable(false);
/*     */     
/*  83 */     setSize(580, 350);
/*     */     
/*  85 */     FrameUtil.setFrameCenter(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initKeyText() {
/*  92 */     int x = 10;
/*  93 */     int y = 65;
/*  94 */     int w = 64;
/*  95 */     int h = 20;
/*  96 */     for (int i = 0; i < 4; i++) {
/*  97 */       this.keyText[i] = new TextCtrl(x, y, w, h, 0, METHOD_NAMES[i]);
/*  98 */       y += 20;
/*     */     } 
/* 100 */     x = 500;
/* 101 */     y = 65;
/* 102 */     for (int i = 4; i < 8; i++) {
/* 103 */       this.keyText[i] = new TextCtrl(x, y, w, h, 0, METHOD_NAMES[i]);
/* 104 */       y += 20;
/*     */     } 
/*     */     try {
/* 107 */       ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/control.dat"));
/*     */       
/* 109 */       HashMap<Integer, String> cfgSet = (HashMap<Integer, String>)ois.readObject();
/* 110 */       ois.close();
/* 111 */       Set<Map.Entry<Integer, String>> entryset = cfgSet.entrySet();
/* 112 */       for (Map.Entry<Integer, String> e : entryset) {
/* 113 */         byte b; int j; TextCtrl[] arrayOfTextCtrl; for (j = (arrayOfTextCtrl = this.keyText).length, b = 0; b < j; ) { TextCtrl tc = arrayOfTextCtrl[b];
/* 114 */           if (tc.getMethodName().equals(e.getValue()))
/* 115 */             tc.setKeyCode(((Integer)e.getKey()).intValue()); 
/*     */           b++; }
/*     */       
/*     */       } 
/* 119 */     } catch (Exception e) {
/* 120 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel createButtonPanel() {
/* 129 */     JPanel jp = new JPanel(new FlowLayout(2));
/*     */     
/* 131 */     this.btnOK.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 133 */             if (JFrameConfig.this.writeConfig()) {
/* 134 */               JFrameConfig.this.setVisible(false);
/* 135 */               JFrameConfig.this.gameControl.setOver();
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 140 */     this.btnCancel.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 142 */             JFrameConfig.this.setVisible(false);
/* 143 */             JFrameConfig.this.gameControl.setOver();
/*     */           }
/*     */         });
/*     */     
/* 147 */     this.btnUser.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 149 */             JFrameConfig.this.writeConfig();
/* 150 */             JFrameConfig.this.gameControl.repaint();
/*     */           }
/*     */         });
/*     */     
/* 154 */     this.errorMsg.setForeground(Color.RED);
/*     */     
/* 156 */     jp.add(this.btnOK);
/*     */     
/* 158 */     jp.add(this.btnCancel);
/*     */     
/* 160 */     jp.add(this.btnUser);
/*     */     
/* 162 */     jp.add(this.errorMsg);
/* 163 */     return jp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JTabbedPane createMainPanel() {
/* 170 */     JTabbedPane jtp = new JTabbedPane();
/* 171 */     jtp.addTab("控制设置", createControlPanel());
/* 172 */     jtp.addTab("皮肤设置", createSkinPanel());
/* 173 */     return jtp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Component createSkinPanel() {
/* 180 */     JPanel panel = new JPanel(new BorderLayout());
/* 181 */     File dir = new File("graphics/");
/* 182 */     File[] files = dir.listFiles();
/* 183 */     this.skinViewList = new Image[files.length];
/* 184 */     for (int i = 0; i < files.length; i++) {
/*     */       
/* 186 */       this.skinData.addElement(files[i].getName());
/*     */       
/* 188 */       this.skinViewList[i] = (new ImageIcon(String.valueOf(files[i].getPath()) + "\\view.jpg")).getImage();
/*     */     } 
/*     */     
/* 191 */     this.skinList = new JList<>(this.skinData);
/*     */     
/* 193 */     this.skinList.setSelectedIndex(0);
/* 194 */     this.skinList.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mouseReleased(MouseEvent e) {
/* 197 */             JFrameConfig.this.repaint();
/*     */           }
/*     */         });
/* 200 */     this.skinView = new JPanel()
/*     */       {
/*     */         public void paintComponent(Graphics g) {
/* 203 */           Image showImg = JFrameConfig.this.skinViewList[JFrameConfig.this.skinList.getSelectedIndex()];
/* 204 */           int x = getWidth() - showImg.getWidth(null) >> 1;
/* 205 */           int y = getHeight() - showImg.getHeight(null) >> 1;
/* 206 */           g.drawImage(showImg, x, y, null);
/*     */         }
/*     */       };
/* 209 */     panel.add(new JScrollPane(this.skinList), "West");
/* 210 */     panel.add(this.skinView, "Center");
/* 211 */     return panel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JPanel createControlPanel() {
/* 218 */     JPanel jp = new JPanel()
/*     */       {
/*     */         public void paintComponent(Graphics g) {
/* 221 */           g.drawImage(IMG_PSP, 0, 0, null);
/*     */         }
/*     */       };
/*     */     
/* 225 */     jp.setLayout(null);
/* 226 */     for (int i = 0; i < this.keyText.length; i++) {
/* 227 */       jp.add(this.keyText[i]);
/*     */     }
/* 229 */     return jp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean writeConfig() {
/* 236 */     HashMap<Integer, String> keySet = new HashMap<>();
/* 237 */     for (int i = 0; i < this.keyText.length; i++) {
/* 238 */       int keyCode = this.keyText[i].getKeyCode();
/* 239 */       if (keyCode == 0) {
/* 240 */         this.errorMsg.setText("错误按键");
/* 241 */         return false;
/*     */       } 
/* 243 */       keySet.put(Integer.valueOf(keyCode), this.keyText[i].getMethodName());
/*     */     } 
/* 245 */     if (keySet.size() != 8) {
/* 246 */       this.errorMsg.setText("重复按键");
/* 247 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/* 251 */       Img.setSkin(String.valueOf(((String)this.skinData.get(this.skinList.getSelectedIndex())).toString()) + "/");
/*     */       
/* 253 */       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/control.dat"));
/* 254 */       oos.writeObject(keySet);
/* 255 */       oos.close();
/* 256 */     } catch (Exception e) {
/* 257 */       this.errorMsg.setText(e.getMessage());
/* 258 */       return false;
/*     */     } 
/* 260 */     this.errorMsg.setText(null);
/* 261 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar\\ui\window\JFrameConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */