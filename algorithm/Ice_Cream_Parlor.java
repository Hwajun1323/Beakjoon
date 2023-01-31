public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < arr.size() - 1; i++) {
            int c1 = arr.get(i);
            for(int j = i + 1; j < arr.size(); j++) {
                
                int c2 = arr.get(j);
                
                if(c1 + c2 == m) {
                    result.add(i + 1);
                    result.add(j + 1);
                    
                    return result;
                }
            }
        }
        
        return result;
    }
