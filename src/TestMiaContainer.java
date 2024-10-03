public class TestMiaContainer {
    public static void main(String[] args) {
        MiaContainer<Integer> miaContainer = new MiaContainer<>();
        MiaContainer<String> miaContainerStrings = new MiaContainer<>();
        for(int i = 1; i <= 20; i++) {
            miaContainer.addData(i);
        }
        for(int i = 1; i <= 20; i++) {
            miaContainerStrings.addData(String.valueOf(i));
        }
        System.out.println(miaContainer);
        System.out.println(miaContainerStrings);
    }
}
