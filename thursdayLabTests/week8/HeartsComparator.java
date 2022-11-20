// Remove public in hackerrank submission
public class HeartsComparator implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        if (o1.getHearts() == o2.getHearts()) return o1.compareTo(o2);
        if (o1.getHearts() > o2.getHearts()) {
            return -1;
        } else {
            return 1;
        }
    }
}
