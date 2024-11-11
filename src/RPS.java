enum RPS implements PlayChoice {
    Rock {
        public boolean beats(PlayChoice other) {
            return other == Scissors;
        }
    }, Paper {
        public boolean beats(PlayChoice other) {
            return other == Rock;
        }
    }, Scissors {
        public boolean beats(PlayChoice other) {
            return other == Paper;
        }
    };

}
