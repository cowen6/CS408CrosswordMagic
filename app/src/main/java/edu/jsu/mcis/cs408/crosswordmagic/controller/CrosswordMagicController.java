package edu.jsu.mcis.cs408.crosswordmagic.controller;

public class CrosswordMagicController extends AbstractController {

    public static final String TEST_PROPERTY = "TestProperty";
    public static final String GRID_DIMENSION_PROPERTY = "GridDimensions";
    public static final String GRID_LETTERS_PROPERTY = "GridLetters";
    public static final String GRID_NUMBERS_PROPERTY = "GridNumbers";
    public static final String CLUES_ACROSS_PROPERTY = "CluesAcross";
    public static final String CLUES_DOWN_PROPERTY = "CluesDown";
    public static final String CHECK_GUESS_PROPERTY = "CheckGuess";
    public static final String GUESS_WORD_PROPERTY = "GuessWord";
    public static final String GUESS_BOX_PROPERTY = "GuessBox";
    public static final String PUZZLE_LIST_PROPERTY = "PuzzleList";

    public void getTestProperty(String value) {
        getModelProperty(TEST_PROPERTY);
    }
    public void getGridDimensions() { getModelProperty(GRID_DIMENSION_PROPERTY); }
    public void getGridLetters() { getModelProperty(GRID_LETTERS_PROPERTY); }
    public void getGridNumbers() { getModelProperty(GRID_NUMBERS_PROPERTY); }
    public void getCluesAcross() { getModelProperty(CLUES_ACROSS_PROPERTY); }
    public void getCluesDown() { getModelProperty(CLUES_DOWN_PROPERTY); }
    public void getCheckGuess() { getModelProperty(CHECK_GUESS_PROPERTY); }
    public void setGuessWord(String input) { setModelProperty(GUESS_WORD_PROPERTY, input); }
    public void setGuessBox(Integer box) { setModelProperty(GUESS_BOX_PROPERTY, box); }
    public void getPuzzleList() { getModelProperty(PUZZLE_LIST_PROPERTY); }
}