package com.addonis.demo.repository.contracts;

import com.addonis.demo.models.Addon;
import com.addonis.demo.models.Tag;
import com.addonis.demo.models.UserInfo;
import com.addonis.demo.models.enums.Status;
import com.addonis.demo.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddonRepository extends BaseRepository<Addon, Integer> {

    @Query("select a from Addon a where a.originLink = :originLink")
    Addon findAddonByOriginLink(@Param("originLink") String originLink);

    List<Addon> findTop6ByStatusOrderByIdDesc(Status status);
    List<Addon> findAllByStatusAndNameContaining(Status status, String name);

    List<Addon> findAllByStatusAndIdeId_IdeName(Status status, String ideName);

    List<Addon> findTop6ByStatusOrderByDownloadsCountDesc(Status status);

    @Query(value = "SELECT * FROM addons WHERE status = 'APPROVED' ORDER BY RAND() LIMIT 6", nativeQuery = true)
    List<Addon> get6Random();

    List<Addon> findAllByStatus(Status status, Sort sort);

    @Query("SELECT a from Addon a WHERE a.status = :status")
    List<Addon> getAddonByStatus(@Param(value = "status") Status status);

    @Query("SELECT a from Addon a WHERE a.userInfo = :user")
    List<Addon> getMyAddons(@Param(value = "user") UserInfo user);

    @Query("select a from Addon a where a.name = :name")
    Addon getByName(@Param("name") String name);

    @Modifying
    @Query("UPDATE Addon set enabled = 0 where name = :name")
    void softDeleteAddonInfo(@Param("name") String name);

    boolean existsByName(String name);

    @Query(value = "SELECT a FROM Addon a JOIN a.tags b WHERE b.tagName = :tagName AND a.status = :status")
    List<Addon> getAllByTagName(@Param("status") Status status, @Param("tagName") String tagName);
}
