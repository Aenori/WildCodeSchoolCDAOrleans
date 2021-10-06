package org.wcscda.worms.gamemechanism.playerrecorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.wcscda.worms.Helper;
import org.wcscda.worms.RandomGenerator;
import org.wcscda.worms.gamemechanism.KeyboardController;

@JsonRootName("GameRecording")
public class KeyboardControllerPlayer extends KeyboardController {
  public static KeyboardControllerPlayer loadFromFile(String filename) {
    JacksonXmlModule module = new JacksonXmlModule();
    module.setDefaultUseWrapper(false);
    XmlMapper xmlMapper = new XmlMapper(module);

    String xml = null;
    try {
      xml = StringUtils.join(Files.readAllLines(new File(filename).toPath()), "");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      KeyboardControllerPlayer kcp = xmlMapper.readValue(xml, KeyboardControllerPlayer.class);
      RandomGenerator.setInstanceWithSeed(kcp.seed);
      return kcp;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return null;
    }
  }

  @JsonProperty private final HashMap<String, String> records = new HashMap<>();

  @JsonProperty private int seed;

  @JsonProperty private String recordDate;

  public void onIterationBegin() {
    if (!records.containsKey("T" + Helper.getClock())) {
      return;
    }

    sendKey(records.get("T" + Helper.getClock()));
  }
}
