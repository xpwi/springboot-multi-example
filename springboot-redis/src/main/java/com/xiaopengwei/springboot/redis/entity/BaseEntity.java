package com.xiaopengwei.springboot.redis.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>
 * 实体类基类 - BaseEntity
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-02
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    @Column(name= "create_date") //创建时间
    Date createDate = new Date();

    @Column(name= "update_date")//修改时间
    Date updateDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



}
