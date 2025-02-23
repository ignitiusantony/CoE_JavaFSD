import React from "react";
import styled from "styled-components";
import { FaFacebook, FaTwitter, FaLinkedin } from "react-icons/fa";

const Card = styled.div`
  width: 300px;
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  text-align: center;
  padding: 20px;
  margin: 10px;
`;

const Name = styled.h3`
  margin: 10px 0;
  font-size: 1.2rem;
  color: #333;
`;

const Role = styled.p`
  font-size: 0.9rem;
  color: #777;
`;

const SocialLinks = styled.div`
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 10px;
`;

const Icon = styled.a`
  color: #555;
  font-size: 1.2rem;
  transition: color 0.3s;

  &:hover {
    color: #0073b1;
  }
`;

const InstructorCard = ({ name, role, facebook, twitter, linkedin }) => {
  return (
    <Card>
      {/* <Image src={image} alt={name} /> */}
      <Name>{name}</Name>
      <Role>{role}</Role>
      <SocialLinks>
        {facebook && (
          <Icon href={facebook} target="_blank" rel="noopener noreferrer">
            <FaFacebook />
          </Icon>
        )}
        {twitter && (
          <Icon href={twitter} target="_blank" rel="noopener noreferrer">
            <FaTwitter />
          </Icon>
        )}
        {linkedin && (
          <Icon href={linkedin} target="_blank" rel="noopener noreferrer">
            <FaLinkedin />
          </Icon>
        )}
      </SocialLinks>
    </Card>
  );
};

export default InstructorCard;
