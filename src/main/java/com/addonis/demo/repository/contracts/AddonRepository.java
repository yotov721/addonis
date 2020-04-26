package com.addonis.demo.repository.contracts;

import com.addonis.demo.models.Addon;
import com.addonis.demo.models.UserInfo;
import com.addonis.demo.repository.base.BaseRepository;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddonRepository extends BaseRepository<Addon, Integer> {

    @Query("select a from Addon a where a.originLink = :originLink")
    Addon findAddonByOriginLink(@Param("originLink") String originLink);

    List<Addon> findAllByNameContaining(String name);

    @Query(value = "SELECT * FROM addons WHERE ide_name in (SELECT ide_id FROM ide WHERE ide_name = :ide)", nativeQuery = true)
    List<Addon> getAllByIDE(@Param("ide") String ideName);

    List<Addon> findAllByIdeId_IdeName(String ideName);
}
