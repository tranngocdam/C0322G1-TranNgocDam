package ss8_clean_code.bai_tap;

public class TennisGame {
    public static final char zero='0';
    public static final char one='1';
    public static final char two='2';
    public static final char three='3';
    public static String getPointBalance(String player1, String player2, int scorePlayer1, int scorePlayer2) {
        String score = "";
        int tempScore=0;
        if (scorePlayer1==scorePlayer2)
        {
            score = getScore(scorePlayer1);
        }
        else if (scorePlayer1>=4 || scorePlayer2>=4)
        {
            score = getPointBalance(scorePlayer1, scorePlayer2);
        }
        else
        {
            score = getScorePlayer(scorePlayer1, scorePlayer2, score);
        }
        return score;
    }

    private static String getScore(int score1) {
        String score;
        switch (score1)
        {
            case zero:
                score = "Love";
                break;
            case one:
                score = "Fifteen";
                break;
            case two:
                score = "Thirty";
                break;
            case three:
                score = "Forty";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static String getScorePlayer(int scorePlayer1, int scorePlayer2, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = scorePlayer1;
            else { score +="-"; tempScore = scorePlayer2;}
            switch(tempScore)
            {
                case zero:
                    score +="Love";
                    break;
                case one:
                    score +="Fifteen";
                    break;
                case two:
                    score +="Thirty";
                    break;
                case three:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private static String getPointBalance(int scorePlayer1, int scorePlayer2) {
        String score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }
}
