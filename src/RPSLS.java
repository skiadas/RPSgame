enum RPSLS implements PlayChoice {
    Rock {
        public boolean beats(PlayChoice other) {
            return other == Scissors || other == Lizard;
        }
    }, Paper {
        public boolean beats(PlayChoice other) {
            return other == Rock || other == Spock;
        }
    }, Scissors {
        public boolean beats(PlayChoice other) {
            return other == Paper;
        }
    }, Lizard {
        public boolean beats(PlayChoice other) {
            return other == Paper;
        }
    }, Spock {
        public boolean beats(PlayChoice other) {
            return other == Scissors || other == Rock;
        }
    };

}
