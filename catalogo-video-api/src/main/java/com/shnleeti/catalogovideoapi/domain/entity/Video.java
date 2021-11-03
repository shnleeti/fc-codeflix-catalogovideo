package com.shnleeti.catalogovideoapi.domain.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Video extends BaseEntity {

    private String title;
    private String description;
    private Integer yearLaunched;
    private Boolean opened = false;
    private String rating;
    private Float duration;
    private List<Category> categories = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    private List<CastMember> castMembers = new ArrayList<>();

    

    public Video(UUID id, String title, String description, Integer yearLaunched, Boolean opened) {
        super.setId(id);
        this.setTitle(title); 
        this.setDescription(description); 
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
    }

    public Video(String title, String description, Integer yearLaunched, Boolean opened) {
        super.generateUUID();
        this.setTitle(title); 
        this.setDescription(description); 
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
    }


    public Video(String title, String description, Integer yearLaunched, Boolean opened, String rating, Float duration) {
        super.generateUUID();
        this.setTitle(title); 
        this.setDescription(description); 
        this.setYearLaunched(yearLaunched);
        this.setOpened(opened);
        this.setRating(rating);
        this.setDuration(duration);
    }

    public Video(String title, String description, Integer yearLaunched,Float duration) {
        super.generateUUID();
        this.setTitle(title); 
        this.setDescription(description); 
        this.setYearLaunched(yearLaunched);
        this.setDuration(duration);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException("title is marked non-null but is null");
        if (title.length() == 0) throw new IllegalArgumentException("title is marked non-blank but is blank");
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearLaunched() {
        return this.yearLaunched;
    }

    public void setYearLaunched(Integer yearLaunched) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yearLaunched > currentYear) throw new IllegalArgumentException("yearLaunched is greater than currentYear");
        this.yearLaunched = yearLaunched;
    }

    public Boolean isOpened() {
        return this.opened;
    }

    public Boolean getOpened() {
        return this.opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Float getDuration() {
        return this.duration;
    }

    public void setDuration(Float duration) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.duration = Float.valueOf(decimalFormat.format(duration));
    }


    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        if (categories == null) throw new IllegalArgumentException("categories is marked non-null but is null");
        this.categories = categories;
    }

    public List<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(List<Genre> genres) {
        if (genres == null) throw new IllegalArgumentException("genres is marked non-null but is null");
        this.genres = genres;
    }

    public List<CastMember> getCastMembers() {
        return this.castMembers;
    }

    public void setCastMembers(List<CastMember> castMembers) {
        if (castMembers == null) throw new IllegalArgumentException("castMembers is marked non-null but is null");
        this.castMembers = castMembers;
    }

    public void addCategory(Category category){
        if (category == null) throw new IllegalArgumentException("category is marked non-null but is null");
        this.categories.add(category);
    }


    public void removeCategory(Category category){
        if (category == null) throw new IllegalArgumentException("category is marked non-null but is null");
        this.categories.remove(category);
    }


    public void addGenre(Genre genre){
        if (genre == null) throw new IllegalArgumentException("genre is marked non-null but is null");
        this.genres.add(genre);
    }

    public void removeGenre(Genre genre){
        if (genre == null) throw new IllegalArgumentException("genre is marked non-null but is null");
        this.genres.remove(genre);
    }

    public void addCastMembers(CastMember castMember){
        if (castMember == null) throw new IllegalArgumentException("castMember is marked non-null but is null");
        this.castMembers.add(castMember);
    }

    public void removeCastMembers(CastMember castMember){
        if (castMember == null) throw new IllegalArgumentException("castMember is marked non-null but is null");
        this.castMembers.remove(castMember);
    }
    
}
