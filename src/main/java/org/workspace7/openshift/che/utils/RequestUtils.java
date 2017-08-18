package org.workspace7.openshift.che.utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class RequestUtils {

  public Map<String, Collection<String>> tagsQueryMap(String... tags) {

    if (tags != null) {
      Multimap<String, String> tagsMap = ArrayListMultimap.create();
      tagsMap.putAll("tags", Arrays.asList(tags));
      return tagsMap.asMap();
    } else {
      return Collections.emptyMap();
    }
  }
}
