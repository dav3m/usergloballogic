package com.globallogic.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class UserEntity {

	@OneToMany(mappedBy="user", fetch=FetchType.LAZY , cascade=CascadeType.PERSIST)
	private List<PhoneEntity> phones;
	
    @Id
    @Column(name="id")
    private String id;
    
	@Column(name="name")
    private String name;
    
    @Column(name="created")
    private Date created;
    
    @Column(name="modified")
    private Date modified;

    @Column(name="lastlogin")
    private Date lastlogin;
    
    @Column(name="isactive")
    private Boolean isactive;
    
	@Column(name="email")
    private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="token")
	private String token;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
}