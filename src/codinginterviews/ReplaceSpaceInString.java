package codinginterviews;

public class ReplaceSpaceInString {
    /**
     * 替换空格
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}