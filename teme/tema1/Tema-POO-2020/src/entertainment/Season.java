package entertainment;

/**
 * Information about a season of a tv show
 * <p>
 * DO NOT MODIFY
 */
public final class Season {
    /**
     * Number of current season
     */
    private final int currentSeason;
    /**
     * Duration in minutes of a season
     */
    private int duration;
    /**
     * List of ratings for each season
     */
    private double rating = 0.0;

    public Season(final int currentSeason, final int duration) {
        this.currentSeason = currentSeason;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Episode{"
                + "currentSeason="
                + currentSeason
                + ", duration="
                + duration
                + '}';
    }
}

