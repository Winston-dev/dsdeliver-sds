import './styles.css';
import {ReactComponent as MainImage} from './main.svg';


function Home(){
    return(
       <div className="home-container">
           <div className="home-cotent">
               <div className="home-actions">
                   <h1 className="home-title">Faça seu pedido <br/> que 
                   entregamos <br/> pra você!!!</h1>
                    <h3>Escolha o seu pedido e em poucos minutos <br/>
                     levaremoss na sua porta</h3>
                     <a href="order" className="home-btn-oreder">
                         FAZER O PEDIDO
                     </a>
                </div>
                <div className="home-image">
                    <MainImage/>
                </div>
           </div>
       </div>
    );
}
export default Home;