public static String gridChallenge(List<String> grid) {
        List<char[]> matrix = grid
                .stream()
                .map(e -> {
                    char[] r = e.toCharArray();
                    Arrays.sort(r);
                    return r;
                }).collect(Collectors.toList());

        for (int i = 0; i < matrix.get(0).length; i++) {
            for (int j = 1; j < matrix.size(); j++) {
                if (matrix.get(j - 1)[i] > matrix.get(j)[i]) {
                    return "NO";
                }
            }
        }
        
        return "YES";
    }
