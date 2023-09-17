
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

import javax.sql.DataSource;

import org.agoncal.quarkus.jdbc.Artist;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ArtistRepository {

    @Inject
    DataSource dataSource;

    public void persists(Artist artist) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO t_artists (id, name, bio, created_date) VALUES (?,?,?,?)";
        artist.setId(Math.abs(new Random(0).nextLong()));
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
            ps.executeUpdate();

        }
        conn.close();
    }

    public Artist findById(Long id) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "SELECT id, name, bio, created_date FROM t_artists WHERE id=?";
        Artist artist = new Artist();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                artist.setId(rs.getLong(1));
                artist.setName(rs.getString(2));
                artist.setBio(rs.getString(3));
                artist.setCreatedDate(rs.getTimestamp(4).toInstant());

            }
        }
        conn.close();
        return artist;
    }
}
