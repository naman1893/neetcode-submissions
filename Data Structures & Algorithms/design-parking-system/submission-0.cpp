class ParkingSystem {
    vector<int> spaces{0, 0, 0};

public:
    ParkingSystem(int big, int medium, int small) {
        spaces[0] = big;
        spaces[1] = medium;
        spaces[2] = small;
    }

    bool addCar(int carType) {
        int index = carType - 1;

        if (spaces[index] == 0) {
            return false;
        }

        spaces[index]--;
        return true;
    }
};