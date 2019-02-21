class Vector2D {
    int[][] vec;
    int curr_row;
    int curr_ind;
    
    public Vector2D(int[][] v) {
        vec = v;
        curr_row = 0;
        curr_ind = 0;
    }
    
    public int next() {
        if (hasNext()) {
            int ret =  vec[curr_row][curr_ind];
            curr_ind++;
            return ret;
        }
        return Integer.MIN_VALUE;
        
    }
    
    public boolean hasNext() {
        if (curr_row >= vec.length) return false;
        if (curr_ind >= vec[curr_row].length) {
            curr_ind = 0;
            curr_row++;
            return hasNext();
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */