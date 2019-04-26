package SpaceBattle;

import Controller.EnvironmentController;
import Model.Player;
import Model.UpdateClass;
import View.Environment;


public class Main {

  public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable(){
      public void run() {
          //Cria o Model do Update
          UpdateClass updater = new UpdateClass(); //Interface gráfica
          UpdateClass fight_updater = new UpdateClass();
          
          //
          
          Player player = new Player();

          //Cria o Controller do Environment - os eventos do jogo são tratados e distribuidos aqui
          EnvironmentController environment_controller = new EnvironmentController();

          //Cria a View do Environment (Painel de jogo)
          Environment environment_view = new Environment(updater, environment_controller.getFightController());


        
          //Conecta os Controller ao respectivo View
          environment_view.addController(environment_controller);
          environment_controller.addView(environment_view);

          //Roda o View
          environment_controller.runEnvironment();
      }
    });
  }
}
