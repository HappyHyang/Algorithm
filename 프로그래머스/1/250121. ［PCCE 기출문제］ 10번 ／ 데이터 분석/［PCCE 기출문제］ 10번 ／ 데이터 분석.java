import java.util.*;

class Product {
    int code;
    int date;
    int maximum;
    int remain;

    public Product(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }

    public int getValueByExt(String field) {
        switch (field) {
            case "code":
                return this.code;
            case "date":
                return this.date;
            case "maximum":
                return this.maximum;
            case "remain":
                return this.remain;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }
}

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Product> products = new ArrayList<>();
        for (int[] d : data) {
            products.add(new Product(d[0], d[1], d[2], d[3]));
        }
        
        List<Product> filtered = new ArrayList<>();
        for (Product product : products) {
            if (product.getValueByExt(ext) < val_ext) {
                filtered.add(product);
            }
        }
        
        filtered.sort(Comparator.comparingInt(p -> p.getValueByExt(sort_by)));
        
        int[][] answer = new int[filtered.size()][4];
        for (int i = 0; i < filtered.size(); i++) {
            Product p = filtered.get(i);
            answer[i][0] = p.code;
            answer[i][1] = p.date;
            answer[i][2] = p.maximum;
            answer[i][3] = p.remain;
        }

        return answer;
    }
}