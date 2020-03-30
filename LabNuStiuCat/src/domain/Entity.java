package domain;

import java.util.Objects;

public class Entity implements java.io.Serializable {

        protected int id;

        Entity(int id)
        {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            domain.Entity entity = (domain.Entity) o;
            return id == entity.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        public String fileToString()
        {
            return Integer.toString(this.id);
        }

}


