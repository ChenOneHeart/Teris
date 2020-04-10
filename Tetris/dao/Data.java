package dao;

import dto.Player;
import java.util.List;

public interface Data {
  List<Player> loadData();
  
  void saveData(Player paramPlayer);
}


/* Location:              D:\Code\俄罗斯方块1.0\Tetris.jar!\dao\Data.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */