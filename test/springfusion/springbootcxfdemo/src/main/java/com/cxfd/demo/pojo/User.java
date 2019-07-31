package com.cxfd.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * @author dusk
 * @since 2019/7/31
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -3819731052835238355L;

    private String userId;
    private String userName;
    private String age;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
