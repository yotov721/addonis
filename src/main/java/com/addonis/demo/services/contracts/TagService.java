package com.addonis.demo.services.contracts;

import com.addonis.demo.models.Tag;
import com.addonis.demo.services.base.BaseServiceContract;

public interface TagService extends BaseServiceContract<Tag, Integer> {

    void deleteTagByName(String name);
    Tag addTagToAddon(int addonId, String tagName, String userName);
    void removeTagFromAddon(int addonId, String tagName);
}
