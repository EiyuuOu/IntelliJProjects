package Chapter_22;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by niko on 22.08.2016.
 */
public class EightQueens extends Application {

        public static final int SIZE = 8; //size of the chess board
        //queens are placed at (i, queens[i])
        //-1 indicates no queen in row
        //initially, place a queen at (0,0)
        private int[] queens = {-1, -1, -1, -1, -1, -1, -1, -1};

        @Override
        public void start(Stage primaryStage){
            search();

            GridPane chessBoard = new GridPane();
            chessBoard.setAlignment(Pos.CENTER);
            Label[][] labels = new Label[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    chessBoard.add(labels[i][j] = new Label(), j, i);
                    labels[i][j].setStyle("-fx-border-color: black");
                    labels[i][j].setPrefSize(55,55);
                }
            }

            //Display queens
            Image image = new Image("image/queen.jpg");
            for (int i = 0; i < SIZE; i++){
                labels[i][queens[i]].setGraphic(new ImageView(image));
            }

            Scene scene = new Scene(chessBoard, 55 * SIZE, 55 * SIZE);
            primaryStage.setTitle("EightQueens");
            primaryStage.setScene(scene);
            primaryStage.show();


        }

        private boolean search(){
            //k -1 indicates the number of queen placed so far
            // we are looking for a position in the kth row to place a queen
            int k = 0;
            while (k >= 0 && k < SIZE){
                //find position to place a queen in the kth row
                int j = findPosition(k);
                if (j < 0){
                    queens[k] = -1;
                    k--;
                }
                else {
                    queens[k] = j;
                    k++;
                }
            }
            if (k == -1) return false;
            else return true;
        }

        public int findPosition(int k){
            int start = queens[k]+1;
            for (int j = start; j < SIZE; j++){
                if (isValid(k,j)) return j; //is the place to put the queens
            }
            return -1;
        }

        public boolean isValid(int row, int column) {
            for (int i = 1; i <= row; i++) {
                if (queens[row - 1] == column || queens[row - i] == column - 1
                        || queens[row - 1] == column + i)
                    return false;

            }
            return true;
        }
    }

