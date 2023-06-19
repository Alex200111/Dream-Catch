import React, { useState, useEffect } from "react";
import { useLocation } from 'react-router-dom';
import axios from "axios";

function App() {

  const location = useLocation();
  const date = location?.state?.date || null;
  const type = location?.state?.type || "7";

  const [image1, setImage1] = useState("");
  const [image2, setImage2] = useState('');
  const [image3, setImage3] = useState("");
  const linkd='http://localhost:8080/chart/durata/'+localStorage.getItem('idUser')+'/'+date.$d.toString().substring(4,15)+'/'+type;
  const links='http://localhost:8080/chart/stres/'+localStorage.getItem('idUser')+'/'+date.$d.toString().substring(4,15)+'/'+type;
  const linke='http://localhost:8080/chart/energie/'+localStorage.getItem('idUser')+'/'+date.$d.toString().substring(4,15)+'/'+type;

  useEffect(() => {
    async function fetchData() {
      const response1 = await axios.get(linkd, {
        responseType: "blob"
      });
      const response2 = await axios.get(links, {
        responseType: "blob"
      });
      const response3 = await axios.get(linke, {
        responseType: "blob"
      });
      const url = window.URL.createObjectURL(new Blob([response1.data]));
      const urls= window.URL.createObjectURL(new Blob([response2.data]));
      const urle= window.URL.createObjectURL(new Blob([response3.data]));

      setImage1(url);
      setImage2(urls);
      setImage3(urle);
    }
    fetchData();
  }, []);

  return (
    <div>
        <center>
      <img src={image1} alt="Image1" />
      <img src={image2} alt="Image2"/>
      <img src={image3} alt="Image3"/>
      </center>
    </div>
  );
}

export default App;