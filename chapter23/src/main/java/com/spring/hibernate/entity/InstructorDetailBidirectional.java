package com.spring.hibernate.entity;

import javax.persistence.*;

/**
 * Created by Dmitrii on 27.01.2019.
 */
@Entity
@Table(name="instructor_detail")
public class InstructorDetailBidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private InstructorBiderectional instructor;


    public InstructorDetailBidirectional() {
    }

    public InstructorDetailBidirectional(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public InstructorBiderectional getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorBiderectional instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetailBidirectional{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby +
                '}';
    }
}
