import './styles.css';
import {ReactComponent as YouTubeIcon} from './youtube.svg';
import {ReactComponent as LinkedinIcon} from './linkedin.svg';
import {ReactComponent as InstagramIcon} from './instagram.svg';


function Footer(){
    return(
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.youtube.com/DevSuperior" target="_new"><YouTubeIcon/></a>
                <a href="http://linkedin.com/school/devsuperior/" target="_new"><LinkedinIcon/></a>
                <a href="https://www.instagram.com/devsuperior.ig/?hl=pt" target="_new"><InstagramIcon/></a>
            </div>
        </footer>
    );
}
export default Footer;