package ro.sapientia2018.epic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import ro.sapientia2018.epic.model.Epic;
import ro.sapientia2018.epic.model.Epic.Builder;

@Entity
@Table(name="epic")
public class Epic {
	public static final int MAX_LENGTH_DESCRIPTION = 500;
    public static final int MAX_LENGTH_TITLE = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "creation_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationTime;

    @Column(name = "description", nullable = true, length = MAX_LENGTH_DESCRIPTION)
    private String description;

    @Column(name = "modification_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;

    @Column(name = "title", nullable = false, length = MAX_LENGTH_TITLE)
    private String title;

    @Version
    private long version;

    public Epic() {

    }

    public static Builder getBuilder(String title) {
        return new Builder(title);
    }

    public Long getId() {
        return id;
    }

    public DateTime getCreationTime() {
        return creationTime;
    }

    public String getDescription() {
        return description;
    }

    public DateTime getModificationTime() {
        return modificationTime;
    }

    public String getTitle() {
        return title;
    }

    public long getVersion() {
        return version;
    }

    @PrePersist
    public void prePersist() {
        DateTime now = DateTime.now();
        creationTime = now;
        modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = DateTime.now();
    }

    public void update(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public static class Builder {

        private Epic built;

        public Builder(String title) {
            built = new Epic();
            built.title = title;
        }

        public Epic build() {
            return built;
        }

        public Builder description(String description) {
            built.description = description;
            return this;
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
