enum PlayChoice {
    Rock {
        boolean beats(PlayChoice other) {
            return other == Scissors;
        }
    }, Paper {
        boolean beats(PlayChoice other) {
            return other == Rock;
        }
    }, Scissors {
        boolean beats(PlayChoice other) {
            return other == Paper;
        }
    };

    abstract boolean beats(PlayChoice other);
}
