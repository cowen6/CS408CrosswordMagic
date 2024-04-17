package edu.jsu.mcis.cs408.crosswordmagic.model;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;

import edu.jsu.mcis.cs408.crosswordmagic.R;
import edu.jsu.mcis.cs408.crosswordmagic.controller.CrosswordMagicController;
import edu.jsu.mcis.cs408.crosswordmagic.model.dao.DAOFactory;
import edu.jsu.mcis.cs408.crosswordmagic.model.dao.GuessDAO;
import edu.jsu.mcis.cs408.crosswordmagic.model.dao.PuzzleDAO;

public class CrosswordMagicModel extends AbstractModel {

    private final int DEFAULT_PUZZLE_ID = 1;

    private Puzzle puzzle;
    private String wordguess = "";
    private int boxguess = 0;
    private DAOFactory daoFactory;

    public CrosswordMagicModel(Context context) {

        this.daoFactory = new DAOFactory(context);
        PuzzleDAO puzzleDAO = daoFactory.getPuzzleDAO();
        /*create new dao for guesses to add guesses to table*/

        this.puzzle = puzzleDAO.find(DEFAULT_PUZZLE_ID);

    }

    public void getTestProperty() {

        String wordCount = (this.puzzle != null ? String.valueOf(puzzle.getSize()) : "none");
        firePropertyChange(CrosswordMagicController.TEST_PROPERTY, null, wordCount);

    }
    public void getGridDimensions() {
        Integer[] dimensions = new Integer[2];
        dimensions[0] = puzzle.getHeight();
        dimensions[1] = puzzle.getWidth();
        firePropertyChange(CrosswordMagicController.GRID_DIMENSION_PROPERTY, null, dimensions);
    }
    public void getGridLetters() {
        Character[][] letters = puzzle.getLetters();
        firePropertyChange(CrosswordMagicController.GRID_LETTERS_PROPERTY, null, letters);
    }
    public void getGridNumbers() {
        Integer[][] numbers = puzzle.getNumbers();
        firePropertyChange(CrosswordMagicController.GRID_NUMBERS_PROPERTY, null, numbers);
    }
    public void getCluesAcross() {
        String across = puzzle.getCluesAcross();
        firePropertyChange(CrosswordMagicController.CLUES_ACROSS_PROPERTY, null, across);
    }
    public void getCluesDown() {
        String down = puzzle.getCluesDown();
        firePropertyChange(CrosswordMagicController.CLUES_DOWN_PROPERTY, null, down);
    }
    public void getCheckGuess() {
        if (this.boxguess != 0 && !this.wordguess.equals("")) {
            WordDirection guessdirection = puzzle.checkGuess(boxguess, wordguess);
            /* Check if guess was correct, return corresponding toast */
            if (guessdirection != null) {
                //add correct guess to database
                GuessDAO guessDAO = daoFactory.getGuessDAO();
                HashMap<String, String> params = new HashMap<>();

                int puzzleid, wordid;
                //???????????HOW TO GET THE WORD AND PUZZLE IDS FOR TABLE INSERTION?????????????????
                params.put(daoFactory.getProperty("sql_field_puzzleid"), String.valueOf(puzzleid));
                params.put(daoFactory.getProperty("sql_field_wordid"), String.valueOf(wordid));

                guessDAO.create(params);

                int correct = R.string.guess_correct;
                firePropertyChange(CrosswordMagicController.CHECK_GUESS_PROPERTY, null, correct);
                getGridLetters();
            }
            else {
                int incorrect = R.string.guess_incorrect;
                firePropertyChange(CrosswordMagicController.CHECK_GUESS_PROPERTY, null, incorrect);
            }
        }
        /* Revert word and box to default */
        this.boxguess = 0;
        this.wordguess = "";
    }
    public void setGuessWord(String word) {
        String oldword = this.wordguess;
        this.wordguess = word;
        Log.i("Model", word);
        firePropertyChange(CrosswordMagicController.GUESS_WORD_PROPERTY, oldword, word);
    }
    public void setGuessBox(Integer box) {
        int oldbox = this.boxguess;
        this.boxguess = box;
        Log.i("Model", String.valueOf(box));
        firePropertyChange(CrosswordMagicController.GUESS_BOX_PROPERTY, oldbox, box);
    }

}