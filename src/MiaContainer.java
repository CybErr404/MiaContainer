public class MiaContainer <T>{
    private int[] data;
    private int currentPosition;
    public MiaContainer() {
        data = new int[10];
        currentPosition = 0;
    }

    public void increaseSize() {
        if(currentPosition == data.length) {
            int[] temp = new int[data.length * 2];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    public void addData(int newData) {
        if(currentPosition == data.length) {
            increaseSize();
        }
        data[currentPosition] = newData;
        currentPosition++;
    }

    public void addData(int position, int newData) {
        if(position == 0) {
            addFirst(newData);
        }
        else if(position == data.length - 1) {
            addData(newData);
        }
        else {
            if(currentPosition == data.length) {
                increaseSize();
            }
            for(int i = data.length - 1; i > position; i--) {
                data[i] = data[i - 1];
            }
            data[position] = newData;
            currentPosition++;
        }
    }

    public void addFirst(int newData) {
        if(currentPosition == data.length) {
            increaseSize();
        }
        for(int i = data.length - 1; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = newData;
        currentPosition++;
    }

    public void addAll(int newData) {
        for(int i = 0; i < data.length; i++) {
            if(!(data[i] == newData)) {
                data[i] = newData;
            }
        }
    }

    public void replace(int position, int newData) {
        data[position] = newData;
    }

    public void remove(int positionToRemove) {
        if(positionToRemove == 0) {
            removeFirst();
        }
        else if(positionToRemove == data.length - 1) {
            data[positionToRemove] = 0;
            currentPosition--;
        }
        else {
            data[positionToRemove] = 0;
            for(int i = positionToRemove; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            data[data.length - 1] = 0;
            currentPosition--;
        }
    }

    public void removeFirst() {
        data[0] = 0;
        for(int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[data.length - 1] = 0;
        currentPosition--;
    }

    public int[] clearContainer() {
        int[] clearedContainer = new int[]{};
        return clearedContainer;
    }

    public int checkSize() {
        return currentPosition;
    }

    public int getElement(int position) {
        return data[position];
    }

    public boolean contains(int userData) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == userData) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int userData) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == userData) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return currentPosition == 0;
    }

    @Override
    public String toString() {
        String newString = "";
        for(int i = 0; i < currentPosition; i++) {
            newString = newString + data[i] + " ";
        }
        return newString;
    }
}
