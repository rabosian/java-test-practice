public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        Song first = this;
        Song sec = this;
        if (first == null || first.nextSong == null) {
            return false;
        }
        while (sec != null && sec.nextSong != null) {
            first = first.nextSong;
            sec = sec.nextSong.nextSong;

            if (sec == first) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
