class ParkingSystem {
    int[] park;

    public ParkingSystem(int big, int medium, int small) {
        park = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        park[carType-1]--;
        return park[carType-1] >=0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
