<?php
  $xml_data = simplexml_load_file("grocery.xml");
  $search_id = $_POST['id'];
  $found = false;

  echo "<body style='background:linear-gradient(135deg, #9be15d, #00e3ae); 
        font-family:Segoe UI, sans-serif; text-align:center; padding-top:60px;'>";

  foreach($xml_data->children() as $item)
  {
      if($item->id == $search_id)
      {
          $found = true;
          echo "<div style='background:white; width:400px; margin:auto; 
                padding:20px; border-radius:15px; box-shadow:0 4px 10px rgba(0,0,0,0.3);'>";
          echo "<h2 style='color:#1b5e20;'>Item Found!</h2>";
          echo "<p><b>Item Name:</b> " . $item->name . "</p>";
          echo "<p><b>Category:</b> " . $item->category . "</p>";
          echo "<p><b>Price:</b> " . $item->price . "</p>";
          echo "<p><b>Stock:</b> " . $item->stock . "</p>";
          echo "</div>";
      }
  }

  if(!$found)
  {
      echo "<h3 style='color:red;'>❌ Item not found. Please try again.</h3>";
  }

  echo "</body>";
?>
